package benhamida.jassem.mvpapplication

class Presenter(
    private var mainView: Contract.View?,
    private val model: Contract.Model) : Contract.Presenter,
    Contract.Model.OnFinishedListener {

    override fun onButtonClick() {
        if (mainView != null) {
            mainView!!.showProgress()
        }
        model.getNextData(this)
    }

    override fun onDestroy() {
        mainView = null
    }

    override fun onFinished(string: String?) {
        if (mainView != null) {
            mainView!!.setString(string)
            mainView!!.hideProgress()
        }
    }

}
