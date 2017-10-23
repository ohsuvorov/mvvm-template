package com.duyp.architecture.mvvm.ui.modules.login;

import com.duyp.androidutils.StringUtils;
import com.duyp.architecture.mvvm.helper.RestHelper;
import com.duyp.architecture.mvvm.ui.base.BaseViewModel;
import com.duyp.architecture.mvvm.data.local.user.UserManager;
import com.duyp.architecture.mvvm.data.remote.GithubService;
import com.duyp.architecture.mvvm.ui.navigator.NavigatorHelper;

import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by duypham on 10/21/17.
 *
 */

@Getter
@Setter
public class LoginViewModel extends BaseViewModel {

    private final GithubService githubService;
    private final NavigatorHelper navigatorHelper;

    private String userName = "duyp1";
    private String password = "Duy1234";

    @Inject
    LoginViewModel(GithubService githubService, UserManager userManager, NavigatorHelper navigatorHelper) {
        super(userManager);
        this.githubService = githubService;
        this.navigatorHelper = navigatorHelper;
    }

    public void login() {
        String auth = StringUtils.getBasicAuth(userName, password);
        execute(RestHelper.createRemoteSourceMapper(githubService.login(auth), null), user -> {
            userManager.startUserSession(user, auth);
            navigatorHelper.navigateMainActivity(true);
        });
    }
}
