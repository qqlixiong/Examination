package com.shlw.cloudclassroom.login;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.shlw.cloudclassroom.launcher.GuideActivity;
import com.shlw.cloudclassroom.MainMainActivity;
import com.shlw.cloudclassroom.R;
import com.shlw.cloudclassroom.base.BaseActivity;
import com.shlw.cloudclassroom.launcher.NoStatusBar;
import com.shlw.cloudclassroom.login.bean.LoginBean;
import com.shlw.cloudclassroom.login.bean.LoginBeanNo;
import com.shlw.cloudclassroom.pubilc.Constant;
import com.shlw.cloudclassroom.pubilc.util.IntentUtil;
import com.shlw.cloudclassroom.pubilc.util.LogUtil;
import com.shlw.cloudclassroom.pubilc.util.SharedPreferenceUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;

public class LoginActivity extends BaseActivity implements NoStatusBar{

    @Bind(R.id.editText_username)
    EditText editTextUsername;
    @Bind(R.id.editText_password)
    EditText editTextPassword;
    private SharedPreferenceUtil sharedPreferenceUtil;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.ib_ok)
    public void ok(View view) {
//        usernamePawLogin();
//        IntentUtil.startActivity(LoginActivity.this, MainMainActivity.class);
        //根据版本号判断是不是第一次使用
        PackageInfo info=null;
        try {
            info=getPackageManager().getPackageInfo(getPackageName(),0);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        final float currentVersion = info.versionCode;
        sharedPreferenceUtil = new SharedPreferenceUtil(LoginActivity.this, Constant.SP);
        float lastVersion = sharedPreferenceUtil.get(Constant.VERSION_KEY, 0f);
        if(currentVersion>lastVersion){
            //第一次启动将当前版本进行存储
            sharedPreferenceUtil.set(Constant.VERSION_KEY,currentVersion);
            IntentUtil.startActivity(LoginActivity.this,GuideActivity.class);
        }else {
            IntentUtil.startActivity(LoginActivity.this,MainMainActivity.class);
        }
        finish();
    }

    private void usernamePawLogin() {
        final String userName = editTextUsername.getText().toString();
        final String password = editTextPassword.getText().toString();
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        String url = "http://edu.joysw.com/web/index.php/api/Login/login";
        StringBuilder sb = new StringBuilder();
        sb.append("{\"mobile\":").append(userName).append(",\"pass\":").append(password).append("}");
        OkHttpUtils
                .post()
                .url(url)
                .addParams("param", sb.toString())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogUtil.i("登录失败返回的信息：" + e);
                        Toast.makeText(LoginActivity.this, "用户名或密码不正确", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        LogUtil.i("请求登录接口成功返回的json：" + response);
                        if (response.contains("\"data\":-1")) {
                            LoginBeanNo loginBeanNo = JSON.parseObject(response, LoginBeanNo.class);
                            Toast.makeText(LoginActivity.this, loginBeanNo.getMsg(), Toast.LENGTH_LONG).show();
                        } else {
                            LoginBean loginBean = JSON.parseObject(response, LoginBean.class);
                            if (loginBean.getCode() == 10000) {
                                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                                IntentUtil.startActivity(LoginActivity.this, MainMainActivity.class);
                                sharedPreferenceUtil.set(Constant.USERNAME,userName);
                                sharedPreferenceUtil.set(Constant.PASSWORD,password);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, loginBean.getMsg(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }

    @Override
    public void initData() {
        super.initData();
        sharedPreferenceUtil = new SharedPreferenceUtil(this, Constant.SP);
        autoLogin();
    }

    private void autoLogin() {
        if(!TextUtils.isEmpty(sharedPreferenceUtil.get(Constant.USERNAME,"")) &&
                !TextUtils.isEmpty(sharedPreferenceUtil.get(Constant.PASSWORD,""))){
            IntentUtil.startActivity(LoginActivity.this, MainMainActivity.class);
            finish();
        }
    }

    @OnClick(R.id.forget_password_tv)
    public void forgetPassword(View view) {
        IntentUtil.startActivity(this, ForgetPasswordActivity.class);
    }

    @OnClick(R.id.register_btn)
    public void register(View view) {
        IntentUtil.startActivity(this, LoginRegisterActivity.class);
    }

    @OnClick(R.id.textView_teacher)
    public void teacher(View view) {
        sharedPreferenceUtil.set(Constant.FLAG, Constant.TEACHER);
        Toast.makeText(this, "已选中教师端,点击登录按钮即可进入教师端主页面", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.textView_student)
    public void student(View view) {
        sharedPreferenceUtil.set(Constant.FLAG, Constant.STUDENT);
        Toast.makeText(this, "已选中学生端,点击登录按钮即可进入学生端主页面", Toast.LENGTH_LONG).show();
    }
}
