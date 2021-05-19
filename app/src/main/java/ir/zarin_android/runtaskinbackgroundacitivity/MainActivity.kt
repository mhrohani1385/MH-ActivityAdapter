package ir.zarin_android.runtaskinbackgroundacitivity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val taskTag = "taskName"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun runTask(view: View){
        val i = Intent(this, RunActivityTask::class.java)

        // Set task name for run .
        i.data = RunActivityTask.parsTaskName(taskTag)

        // Add task to run before start activity
        RunActivityTask.addTask(taskTag,
                object : RunActivityTask.ActivityRunnable {
                    override fun run(activity: RunActivityTask) {




                        // Run your task here .
                        Handler(Looper.getMainLooper()).postDelayed(
                                {



                                    // Show Toast For Test
                                    Toast.makeText(this@MainActivity,"Task runned",Toast.LENGTH_LONG).show()

                                    // Once you are sure that your task is done
                                    activity.closeActivity()




                                },1000
                        )




                    }
                }
        )

        onBackPressed()
        startActivity(i)
        finish()
    }


}