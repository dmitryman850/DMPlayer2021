package dmitry.man.dmplayer2021

interface MainView {

    fun setLoading(loading: Boolean)

    fun showEmailError()

    fun showPasswordError()

    fun showSuccess()
}