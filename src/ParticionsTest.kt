import java.io.File
import java.util.concurrent.Executors
import javax.swing.filechooser.FileSystemView


val system = FileSystemView.getFileSystemView()!!

var filePath = ""
val fileName = "Xubuntu 16.04 x86-64 vbox.vbox"
var isEnd = false
var normalTime :Long = 0
var parallelTime :Long = 0

fun main(args: Array<String>){
    val partitions = File.listRoots()
    val handler = ThreadHandler(Executors.newFixedThreadPool(5))
    normalTime = System.currentTimeMillis()
    var i = 0
    while(i<partitions.size) {
        getAllFiles(partitions[i++].listFiles())
        if(filePath != "")
            break
    }
    normalTime = System.currentTimeMillis() - normalTime
    i = 0
    parallelTime = System.currentTimeMillis()
    while(i<partitions.size){
        val thread = Thr(partitions[i].listFiles(),handler,fileName)
        handler.executeThread(thread)
        i++
    }
    while(handler.isTerminated == false) continue
    parallelTime = System.currentTimeMillis() - parallelTime
    println("Normal Running Time: "+ normalTime)
    println("Parallel Running Time: "+ parallelTime)
}

fun getAllFiles(files: Array<File>?) {
    if(files == null)
        return
    var i = 0
    while(i < files.size && !isEnd){
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
    return
}
