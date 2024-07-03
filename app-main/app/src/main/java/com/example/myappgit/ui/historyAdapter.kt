import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myappgit.R
import com.example.myappgit.ui.CaptureImage

class historyAdapter(private val capturedImages: List<CaptureImage>) :
    RecyclerView.Adapter<historyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val captureImage = capturedImages[position]
        holder.bind(captureImage)
    }

    override fun getItemCount(): Int {
        return capturedImages.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.historyImageView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)

        fun bind(captureImage: CaptureImage) {
            imageView.setImageBitmap(captureImage.bitmap)
            descriptionTextView.text = captureImage.description
        }
    }
}
