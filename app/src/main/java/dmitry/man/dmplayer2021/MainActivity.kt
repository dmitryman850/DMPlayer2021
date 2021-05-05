package dmitry.man.dmplayer2021

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity(), MainView {
    private var mainPresenter = MainPresenter(
        interactor = AuthorizationInteractor(dispatcher = Dispatchers.Default),
        mainDispatcher = Dispatchers.Main.immediate
    )
    private var emailNameInput: EditText? = null
    private var passwordInput: EditText? = null
    private var btnLogin: Button? = null
    private var btnRegistration: Button? = null
    private var progressBarAuth: View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setUpListeners()

        mainPresenter.attachView(this)
    }

    override fun onDestroy() {
        mainPresenter.detachView()
        mainPresenter.onDestroy()
        // нужно ли тут прописывать:
//            emailNameInput = null или это только в фрагментах
        super.onDestroy()
    }

    private fun init() {
        emailNameInput = findViewById(R.id.edit_txt_email_main_activity)
        passwordInput = findViewById(R.id.edit_txt_password_main_activity)
        btnLogin = findViewById(R.id.btn_login_main_activity)
        btnRegistration = findViewById(R.id.btn_registration_main_activity)
        progressBarAuth = findViewById(R.id.progress_bar_main_activity)
    }

    private fun setUpListeners() {
        btnLogin?.setOnClickListener {
            tryToLogin()
        }
        btnRegistration?.setOnClickListener {
            tryToRegistration()
        }
    }

    private fun tryToLogin() {
        val inputEmailName = emailNameInput?.text?.toString().orEmpty()
        val inputPassword = passwordInput?.text?.toString().orEmpty()
        mainPresenter.login(emailName = inputEmailName, password = inputPassword)
    }

    private fun tryToRegistration() {
        val inputEmailName = emailNameInput?.text?.toString().orEmpty()
        val inputPassword = passwordInput?.text?.toString().orEmpty()
        mainPresenter.registration(emailName = inputEmailName, password = inputPassword)
    }

    override fun setLoading(loading: Boolean) {
        btnRegistration?.isEnabled = !loading
        btnLogin?.isEnabled = !loading
        progressBarAuth?.isVisible = loading
        emailNameInput?.isEnabled = !loading
        passwordInput?.isEnabled = !loading
    }

    override fun showEmailError() {
        emailNameInput?.error = getString(R.string.email_error_main_activity)
    }

    override fun showPasswordEmptyError() {
        passwordInput?.error = getString(R.string.password_error_empty_main_activity)
    }

    override fun showPasswordMinError() {
        passwordInput?.error = getString(R.string.password_error_min_six_main_activity)
    }

    override fun showSuccessRegistration() {
        btnRegistration?.isVisible = true
        btnLogin?.isVisible = true
        Toast.makeText(this, "Успешная регистрация", Toast.LENGTH_SHORT).show()
    }

    override fun showSuccessLogin() {
        btnRegistration?.isVisible = true
        btnLogin?.isVisible = true
        Toast.makeText(this, "Успешный вход", Toast.LENGTH_SHORT).show()
    }

    override fun openPlayerActivity() {
        startActivity(Intent(this, PlayerActivity::class.java))
    }
}