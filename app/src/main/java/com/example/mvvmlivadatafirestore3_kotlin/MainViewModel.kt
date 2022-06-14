package com.example.mvvmlivadatafirestore3_kotlin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

class MainViewModel: ViewModel() {
    private var mFire = FirebaseFirestore.getInstance()
     var mMutableLiveData = MutableLiveData<ArrayList<MainModel>>()
     private var mArrayList = ArrayList<MainModel>()

    private fun init() {
        getData()
        mMutableLiveData.value = mArrayList

    }

    private fun getData() {
        mFire.collection("Tests").get()
            .addOnSuccessListener  { queryDocumentSnapshots ->
                if (!queryDocumentSnapshots.isEmpty) {
                    val mList : List<DocumentSnapshot> = queryDocumentSnapshots.documents
                    for ( documentSnapShot : DocumentSnapshot in mList){
                        mArrayList.add(documentSnapShot.toObject(MainModel::class.java)!!)
                        Log.d("TestAddedRec", "onSucces")
                    }

                }
            }
            .addOnFailureListener{
                Log.d("LogFailed", "onFailure")
            }
    }

    init {
        init()
    }
}