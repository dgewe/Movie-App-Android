package com.fredrikbogg.movie_app.ui.person_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fredrikbogg.movie_app.data.db.repository.PersonRepository
import com.fredrikbogg.movie_app.data.model.Event
import com.fredrikbogg.movie_app.data.model.GoToCredit
import com.fredrikbogg.movie_app.data.model.GoToImage
import com.fredrikbogg.movie_app.data.model.entity.Credit
import com.fredrikbogg.movie_app.data.model.entity.Image
import com.fredrikbogg.movie_app.data.model.entity.Person
import com.fredrikbogg.movie_app.ui.BaseViewModel
import com.fredrikbogg.movie_app.util.extension.liveDataBlockScope

class PersonDetailsViewModelFactory(private val personId: Int) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PersonDetailsViewModel(personId) as T
    }
}

class PersonDetailsViewModel(personId: Int) : BaseViewModel(), GoToImage, GoToCredit {

    private val personRepository = PersonRepository()
    val person: LiveData<Person>
    val imageList: LiveData<List<Image>>
    val creditList: LiveData<List<Credit>>

    override val goToImageEvent: MutableLiveData<Event<Image>> = MutableLiveData()
    override val goToCreditEvent: MutableLiveData<Event<Credit>> = MutableLiveData()

    init {
        person = liveDataBlockScope {
            personRepository.loadDetails(personId) { mSnackBarText.postValue(Event(it)) }
        }

        imageList = liveDataBlockScope {
            personRepository.loadImages(personId) { mSnackBarText.postValue(Event(it)) }
        }

        creditList = liveDataBlockScope {
            personRepository.loadCredits(personId) { mSnackBarText.postValue(Event(it)) }
        }
    }
}