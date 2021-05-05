package dmitry.man.dmplayer2021

interface MainView {

    fun setLoading(loading: Boolean)

    fun showEmailError()

    fun showPasswordEmptyError()

    fun showPasswordMinError()

    fun showSuccessRegistration()

    fun showSuccessLogin()

    fun openPlayerActivity()
}