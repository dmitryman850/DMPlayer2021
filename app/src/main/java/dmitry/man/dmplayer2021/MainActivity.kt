package dmitry.man.dmplayer2021

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setUpListeners()

        mainPresenter.attachView(this)
    }

    override fun onDestroy() {
        mainPresenter.detachView()
        // нужно ли тут прописывать:
//            emailNameInput = null или это только в фрагментах
        super.onDestroy()
    }

    private fun init() {
        emailNameInput = findViewById(R.id.edit_txt_email_main_activity)
        passwordInput = findViewById(R.id.edit_txt_password_main_activity)
        btnLogin = findViewById(R.id.btn_login_main_activity)
        btnRegistration = findViewById(R.id.btn_registration_main_activity)
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
        TODO("Not yet implemented")
    }

    override fun showEmailError() {
        Toast.makeText(this, "email error", Toast.LENGTH_SHORT).show()
    }

    override fun showPasswordError() {
        TODO("Not yet implemented")
    }

    override fun showSuccess() {
        TODO("Not yet implemented")
    }
}