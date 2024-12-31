package benhamida.jassem.mvpapplication

import android.os.Handler
import java.util.*


class Model : Contract.Model {

    private val arrayList =
        Arrays.asList(
            "Alice - A+",
            "Bob - B",
            "Charlie - C+",
            "David - A",
            "Eve - B+",
            "Fiona - C",
            "George - A-",
            "Hannah - B-",
            "Ian - C-"
        )

    override fun getNextData(onFinishedListener: Contract.Model.OnFinishedListener?) {
        Handler().postDelayed({ onFinishedListener!!.onFinished(getRandomString) }, 1200)
    }

    private val getRandomString: String
        private get() {
            val random = Random()
            val index = random.nextInt(arrayList.size)
            return arrayList[index]
        }
}
