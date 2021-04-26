package dmitry.man.dmplayer2021

import kotlinx.coroutines.*

class MainPresenter(
    private val interactor: AuthorizationInteractor,
    private val mainDispatcher: CoroutineDispatcher
) {

    private val presenterScope: CoroutineScope =
        CoroutineScope(SupervisorJob() + mainDispatcher)

    private var mainView: MainView? = null

    fun attachView(view: MainActivity) {
        this.mainView = view
    }

    fun detachView() {
        this.mainView = null
    }

    fun onDestroy() {
        presenterScope.cancel()
    }

    fun login(emailName: String, password: String) {
        presenterScope.launch {
            //mainView?.setLoading(loading = true)

            val loginResult = interactor.login(emailName = emailName, password = password)
            when(loginResult) {
                is LoginResult.Error.EmailName -> mainView?.showEmailError()
                is LoginResult.Error.Password -> mainView?.showPasswordError()
                is LoginResult.Success -> mainView?.showSuccess()
            }

            //mainView?.setLoading(loading =  true)
        }
    }

    fun registration(emailName: String, password: String) {
        presenterScope.launch {
            mainView?.setLoading(loading = true)

            val registrationResult = interactor.registration(emailName = emailName, password = password)
            when(registrationResult) {
                is RegistrationResult.Error.EmailName -> mainView?.showEmailError()
                is RegistrationResult.Error.Password -> mainView?.showEmailError()
                is RegistrationResult.Success -> mainView?.showSuccess()
            }
           // mainView?.setLoading(loading = true)
        }
    }
}