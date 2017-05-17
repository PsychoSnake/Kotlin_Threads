/*import java.awt.Dimension
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.SwingConstants

class ThrTest(val unit: Int, val handler: ThreadHandle) : Thread() {

        override fun run() {
            if(unit == 3)
                handler.terminate(this)
        }

    }

    class ThreadHandle(val param: Thread) {

        var threadToReturn : Thr
            get() = this.threadToReturn
            set(value) {this.threadToReturn = value}

        var nThreads = 0
        var isTerminated = false

        fun terminate (thread: Thr) {
            threadToReturn = thread
            isTerminated = true
        }

        fun executeThread (thread: Thr) {
            thread.start()
            nThreads++
        }

    }*/


    var threads = ArrayList<Thr>()
    val ints = intArrayOf(1,2,3,4,5,6,7,8,9,10)

    /*fun main(args: Array<String>){
        val handler = ThreadHandle(Thread.currentThread())
        var i = 0
        while(!handler.isTerminated && i < ints.size) {
            val thr = Thr(ints[i],handler)
            threads.add(thr)
            handler.executeThread(thr)
            i++
            Thread.sleep(200)
        }
        println("Number of threads executed : "+handler.nThreads)
    }*/


/*
fun main(args: Array<String>){
    */
/*val threadHandler = ThreadHandler(Executors.newFixedThreadPool(20000))
    var i = 0
    val ints = Array(20000, { i -> (i+1) })
    while(i < ints.size) {
        val thr = Runable(threadHandler, ints[i])
        threadHandler.executeThread(thr)
        i++
    }
    println("Number of threads executed: "+threadHandler.nThreads+";")*//*



    javax.swing.SwingUtilities.invokeLater { createAndShowGUI() }
}

private fun createAndShowGUI(){
    val frame = JFrame("Paralleling")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

    //Add the ubiquitous "Hello World" label.
    val label = JLabel("Hello World")
    label.horizontalAlignment = SwingConstants.CENTER
    label.size = Dimension(250,100)

    val b = JButton()
    //b.size = Dimension(800,480)
    b.text = "Press me"
    frame.contentPane.add(b)

    //frame.contentPane.add(label)
    val l = frame.components
    //Display the window.
    frame.pack()
    frame.size = Dimension(1920,1080)

    frame.isVisible = true
}*/
