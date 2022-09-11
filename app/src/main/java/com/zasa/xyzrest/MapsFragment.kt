package com.zasa.xyzrest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        val boundsBuilder = LatLngBounds.Builder()

        val colombo = LatLng(6.905552, 79.850086)
        boundsBuilder.include(colombo)
        googleMap.addMarker(MarkerOptions().position(colombo).title("Branch in Colombo"))

        val galle = LatLng(6.027569, 80.216585)
        boundsBuilder.include(galle)
        googleMap.addMarker(MarkerOptions().position(galle).title("Branch in galle"))

        val kandy = LatLng(7.2915073, 80.6373148)
        boundsBuilder.include(kandy)
        googleMap.addMarker(MarkerOptions().position(kandy).title("Branch in kandy"))

        val anuradhapura = LatLng(8.3339382, 80.4103734)
        boundsBuilder.include(anuradhapura)
        googleMap.addMarker(MarkerOptions().position(anuradhapura).title("Branch in anuradhapura"))

        val negombo = LatLng(7.2124591, 79.8442834)
        boundsBuilder.include(negombo)
        googleMap.addMarker(MarkerOptions().position(negombo).title("Branch in negombo"))

        val jaffna = LatLng(9.6675924, 80.0165518)
        boundsBuilder.include(colombo)
        googleMap.addMarker(MarkerOptions().position(jaffna).title("Branch in jaffna"))
        googleMap.moveCamera(
            CameraUpdateFactory.newLatLngBounds(
                boundsBuilder.build(),
                1000,
                1000,
                0
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

}