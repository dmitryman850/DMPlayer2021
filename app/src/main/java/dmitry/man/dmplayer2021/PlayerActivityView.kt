package dmitry.man.dmplayer2021

import androidx.fragment.app.Fragment

interface PlayerActivityView {

    fun showListOfMusic()

    fun showCurrentTrack()

    fun showFavoriteTracks()

    fun showSettings()

    fun openFragment(fragment: Fragment, addToBackStack: Boolean)
}