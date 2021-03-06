package com.nandaadisaputra.projectakhir.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nandaadisaputra.projectakhir.R
import com.nandaadisaputra.projectakhir.ui.activity.product.DeleteActivity
import com.nandaadisaputra.projectakhir.ui.activity.product.ShowActivity
import kotlinx.android.synthetic.main.fragment_menu.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity


class MenuFragment : Fragment() {

    lateinit var contentView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        contentView = inflater.inflate(R.layout.fragment_menu, container, false)
        contentView.imageView1.onClick {
            val ft = fragmentManager?.beginTransaction()?.replace(R.id.menu, AddProductFragment())
            ft?.commit()
        }
        contentView.imageView2.onClick {
            startActivity<DeleteActivity>()
        }
        contentView.imageView3.onClick {
            startActivity<ShowActivity>()
        }
        return contentView
    }
    companion object {
        fun newInstance(): MenuFragment {
            val fragment = MenuFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment

        }
    }

}
