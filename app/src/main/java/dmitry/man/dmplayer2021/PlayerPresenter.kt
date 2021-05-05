package dmitry.man.dmplayer2021

import android.view.MenuItem

class PlayerPresenter {

    private var playerActivityView: PlayerActivityView? = null

    fun attachView(view: PlayerActivity) {
        this.playerActivityView = view
    }

    fun onDetachView() {
        this.playerActivityView = null
    }

    fun choiceBottomNavigationItem(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.bottom_navigation_item_list -> {
                val listOfMusicFragment = ListOfMusicFragment.newInstance()
                playerActivityView?.openFragment(listOfMusicFragment, true)
                return true
            }
            R.id.bottom_navigation_item_current_track -> {
                val currentTrackFragment = CurrentTrackFragment.newInstance()
                playerActivityView?.openFragment(currentTrackFragment, true)
                return true
            }
            R.id.bottom_navigation_item_favorite -> {
                val favoriteTracksFragment = FavoriteTracksFragment()
                playerActivityView?.openFragment(favoriteTracksFragment, true)
                return true
            }
            R.id.bottom_navigation_item_settings -> {
                val settingsFragment = SettingsFragment()
                playerActivityView?.openFragment(settingsFragment, true)
                return true
            }
            else -> {
                return true
            }
        }
    }
}