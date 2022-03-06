package es.openbank.dev.data.remote

import com.google.common.truth.Truth.assertThat
import es.openbank.dev.TestApp
import es.openbank.dev.di.DaggerTestAppComponent
import es.openbank.remote.ApiKeyConfigContract
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import javax.inject.Inject

@Ignore("I don't need to test this all the time")
class AuthHashTest {
    private val ts = "1"
    private val correctHash = "YOUR HASH"

    @Inject
    lateinit var sut: ApiKeyConfigContract

    @Before
    fun setup() {
        DaggerTestAppComponent.builder()
            .application(TestApp())
            .build()
            .inject(this)
    }

    @Test
    fun `md5 hash is generated correctly from timeStamp, private key and public key`() {
        assertThat(sut.getHash(ts)).isEqualTo(correctHash)
    }
}