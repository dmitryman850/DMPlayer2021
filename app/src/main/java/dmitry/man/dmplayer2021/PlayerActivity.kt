package dmitry.man.dmplayer2021

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class PlayerActivity : AppCompatActivity(), PlayerActivityView {

    private var playerPresenter = PlayerPresenter()
    private var toolbar: ActionBar? = null
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            playerPresenter.choiceBottomNavigationItem(item)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        playerPresenter.attachView(this)

        if (savedInstanceState == null) {
            openFragment(ListOfMusicFragment.newInstance(), addToBackStack = false)
        }
        toolbar = supportActionBar
        val bottomNavigation: BottomNavigationView =
            findViewById(R.id.bottom_navigation_activity_player)
        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        bottomNavigation.menu.findItem(R.id.bottom_navigation_item_list).isChecked = true
    }

    override fun onDestroy() {
        playerPresenter.onDetachView()
        super.onDestroy()
    }

    override fun showListOfMusic() {
        TODO("Not yet implemented")
    }

    override fun showCurrentTrack() {
        TODO("Not yet implemented")
    }

    override fun showFavoriteTracks() {
        TODO("Not yet implemented")
    }

    override fun showSettings() {
        TODO("Not yet implemented")
    }

    override fun openFragment(fragment: Fragment, addToBackStack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.container_activity_player, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(fragment::class.java.name)
        }
        transaction.commit()
    }
}