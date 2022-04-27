package com.inpows.weapow.data.city.source

import com.inpows.weapow.data.AbstractEntityDataFactory
import com.inpows.weapow.data.Source
import javax.inject.Inject


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version ChangeCityEntityDataFactory, v 0.1 24/04/22 17.59 by Fauhan Handay Pugar
 */
class ChangeCityEntityDataFactory @Inject constructor(
    private val localChangeCityEntityData: LocalChangeCityEntityData
) : AbstractEntityDataFactory<ChangeCityEntityData>() {
    override fun createData(source: String?): ChangeCityEntityData {
        return when(source){
            Source.LOCAL -> localChangeCityEntityData
            else -> {localChangeCityEntityData}
        }
    }
}