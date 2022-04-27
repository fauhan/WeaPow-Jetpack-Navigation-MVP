package com.inpows.weapow.city.listener

import android.view.View


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version CityRVClickListener, v 0.1 25/04/22 10.25 by Fauhan Handay Pugar
 */
interface CityRVClickListener {
    fun onItemClicked(view: View, cityId: String)
}