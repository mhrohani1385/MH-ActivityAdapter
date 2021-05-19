package ir.zarin_android.runtaskinbackgroundacitivity

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class RunActivityTask : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.data?.toString()?.run {
            Log.d("RunActivityTask", "geted uri : $this")
            val taskName = this.replace("task_name://", "")
            if (mm.contains(taskName)) {
                mm[taskName]!!.run(this@RunActivityTask)
                return
            }
        }

        Log.d("RunActivityTask", "onCreate: Not Found Task")
        onBackPressed()

        throw RuntimeException("Not find task for run")

    }

    companion object {
        private var mm: MutableMap<String, ActivityRunnable> = mutableMapOf()

        fun addTask(key: String, task: ActivityRunnable) {
            if (!mm.contains(key))
                mm[key] = task
        }

        fun parsTaskName(taskName: String): Uri {
            return Uri.parse("task_name://$taskName")
        }
    }

    interface ActivityRunnable {
        fun run(activity: RunActivityTask)
    }

    fun closeActivity(){
        onBackPressed()
        finish()
    }

}