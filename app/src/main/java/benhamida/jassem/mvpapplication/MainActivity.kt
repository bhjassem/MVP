package benhamida.jassem.mvpapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), Contract.View {

    private var dataTV: TextView? = null
    private var button: Button? = null
    private var progressBar: ProgressBar? = null
    var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataTV = findViewById(R.id.data)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)
        presenter = Presenter(this, Model())
        this.button!!.setOnClickListener(View.OnClickListener { presenter!!.onButtonClick() })
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
        dataTV!!.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
        dataTV!!.visibility = View.VISIBLE
    }

    override fun setString(string: String?) {
        dataTV!!.text = string
    }
}
