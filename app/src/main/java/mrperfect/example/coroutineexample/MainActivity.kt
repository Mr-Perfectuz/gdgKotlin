package mrperfect.example.coroutineexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.os.IResultReceiver
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val RESULT_1 = "Result #1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{

            // IO, Main, Default
            CoroutineScope(IO).launch {
                fakeApiRequest()
            }

        }
    }

    private fun setNewText(input: String) {
        val newText = text.text.toString() + "\n$input"
    }

    private suspend fun fakeApiRequest() {
        val result1 = getResult1FromApi()
        println("debug: $result1")
        text.setText(result1)
    }

    private suspend fun getResult1FromApi(): String {
        logThread("getResult1FromApi")
        delay(1000)
        Thread.sleep(1000)
        return RESULT_1

    }

    private fun logThread(methodName: String) {
        println("debug: ${methodName}: ${Thread.currentThread().name}" )
    }
}