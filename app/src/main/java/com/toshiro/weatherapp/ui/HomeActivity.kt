package com.toshiro.weatherapp.ui

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.github.florent37.runtimepermission.kotlin.askPermission
import com.toshiro.weatherapp.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices


class HomeActivity : AppCompatActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var longitude: Double? = null
    private var latitude: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        requestLocationPermission()

        showLocation()

        PackageManager.PERMISSION_GRANTED

    }

    private fun showLocation() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                Log.d("HomeActivityLog", location.toString())
                longitude = location!!.longitude
                latitude = location.latitude
                Log.d("HomeActivityLog", longitude.toString() + " " + latitude.toString())

            }

    }

    private fun requestLocationPermission() {
        askPermission(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) {
            showLocation()

        }.onDeclined { e ->
            if (e.hasDenied()) {
                Toast.makeText(this, "hasDenied", Toast.LENGTH_LONG).show()
                e.askAgain()
                return@onDeclined
            }

            if (e.hasForeverDenied()) {
                Toast.makeText(this, "hasForeverDenied", Toast.LENGTH_LONG).show()
                e.goToSettings()
            }
        }
    }

}
