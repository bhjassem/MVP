package benhamida.jassem.mvpapplication

interface Contract {
    interface View {
        fun showProgress()

        fun hideProgress()

        fun setString(string: String?)
    }

    interface Model {
        interface OnFinishedListener {
            fun onFinished(string: String?)
        }

        fun getNextData(onFinishedListener: OnFinishedListener?)
    }

    interface Presenter {
        fun onButtonClick()

        fun onDestroy()
    }
}
