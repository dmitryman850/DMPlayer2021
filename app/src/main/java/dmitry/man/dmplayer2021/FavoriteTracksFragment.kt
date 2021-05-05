package dmitry.man.dmplayer2021

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FavoriteTracksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_tracks, null)
    }

    companion object {
        fun newInstance(): FavoriteTracksFragment = FavoriteTracksFragment()
    }
}