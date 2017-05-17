
import java.io.File
import java.util.concurrent.ExecutorService

class Thr(val files : Array<File>?, val handler : ThreadHandler, val fileName : String) : Thread() {

    var isEnd = false

    override fun run() {
        if(files == null)
            return
        val file = getAllFiles(files)
        if(file != null) {
            handler.fileToReturn = file
            handler.isTerminated = true
        }
    }

    fun getAllFiles(files: Array<File>?) : File? {
        if(files == null)
            return null
        var i = 0
        while(i < files.size && handler.isTerminated == false && !isEnd){
            if(files[i].isDirectory && files[i].canRead() && files[i].canWrite())
                getAllFiles(files[i].listFiles())
            else {
                if(system.getSystemDisplayName(files[i]) == fileName){
                    filePath = files[i].canonicalPath
                    isEnd = true
                }
            }
            i++
        }
        return if (isEnd) files[i-1] else null
    }

}

class ThreadHandler (executor: ExecutorService){
    var thrHandler = executor

    private var _fileToReturn :File? = null

    var fileToReturn : File?
        get() = _fileToReturn
        set(value) {_fileToReturn = value}

    var nThreads = 0
    private var _isTerminated :Boolean? = false

    var isTerminated : Boolean?
        get() = _isTerminated
        set(value) {_isTerminated = value}

    fun executeThread (thread: Thr) {
        thread.start()
        nThreads++
    }
}




