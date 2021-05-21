package com.example.toolbaractivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.toolbaractivity.R.id
import com.example.toolbaractivity.fragments.FirstFragment
import com.example.toolbaractivity.fragments.SegundoFragment
import com.example.toolbaractivity.fragments.TercerFragment
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity(), View.OnClickListener{
    private var botonc: Button?=null
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout: TabLayout = findViewById(id.tabLayout)
        val viewPager: ViewPager = findViewById(id.viewpager)
        val botonc: Button = findViewById(id.boton)
        botonc.setOnClickListener(this)

        val viewPagerAdapter = ViewPagerAdapterMio(supportFragmentManager)
        viewPagerAdapter.addFragment(FirstFragment(), "First")
        viewPagerAdapter.addFragment(SegundoFragment(), "SEcond")
        viewPagerAdapter.addFragment(TercerFragment(),"Third")

        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.boton -> {
                Toast.makeText(
                    this@MainActivity,
                    "Please write message, first... ",
                    Toast.LENGTH_LONG
                ).show()
                val intent = Intent(this@MainActivity, TabLayoutActivity2::class.java)
                startActivity(intent)
                }
            }

    }

    // definimos el adapter
    internal class ViewPagerAdapterMio(fragmentManager: FragmentManager) :
        FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
    {
        private val fragments: ArrayList<Fragment> = ArrayList()
        private val titles: ArrayList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragments.add(fragment)
            titles.add(title)
        }

        override fun getPageTitle(i: Int): CharSequence? {
            return titles[i]
        }
    }

}