package dmitry.man.dmplayer2021

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ListOfMusicFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_of_music, null)
    }

    companion object {
        fun newInstance(): ListOfMusicFragment = ListOfMusicFragment()
    }
}