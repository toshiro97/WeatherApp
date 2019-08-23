package com.toshiro.weatherapp.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.toshiro.weatherapp.R
import com.toshiro.weatherapp.utils.checkSelfPermissionCompat
import com.toshiro.weatherapp.utils.requestPermissionsCompat
import com.toshiro.weatherapp.utils.shouldShowRequestPermissionRationaleCompat
import com.toshiro.weatherapp.utils.showSnackbar
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_home.*

const val PERMISSION_REQUEST_LOCATION = 100

class HomeActivity : AppCompatActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var longitude: Double? = null
    private var latitude: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        showLocation()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSION_REQUEST_LOCATION) {

            if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                contentHome.showSnackbar(R.string.location_permission_granted, Snackbar.LENGTH_SHORT)
            } else {
                contentHome.showSnackbar(R.string.location_permission_denied, Snackbar.LENGTH_SHORT)

            }
        }
    }

    private fun showLocation() {

        if (checkSelfPermissionCompat(Manifest.permission.ACCESS_COARSE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED
        ) {

            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    longitude = location!!.longitude
                    latitude = location.latitude
                }
        } else {
            requestLocationPermission()
        }

    }

    private fun requestLocationPermission() {
        if (shouldShowRequestPermissionRationaleCompat(Manifest.permission.ACCESS_COARSE_LOCATION)) {
            contentHome.showSnackbar(
                R.string.location_access_required,
                Snackbar.LENGTH_INDEFINITE, R.string.ok
            ) {

                requestPermissionsCompat(
                    arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                    PERMISSION_REQUEST_LOCATION
                )
            }

        } else {
            contentHome.showSnackbar(R.string.location_permission_not_available, Snackbar.LENGTH_SHORT)
            requestPermissionsCompat(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), PERMISSION_REQUEST_LOCATION)
        }
    }

}
