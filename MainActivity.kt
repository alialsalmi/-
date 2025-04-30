class MainActivity : AppCompatActivity() {

    private val PICK_VIDEO_REQUEST = 1
    private var videoUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnSelectVideo).setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "video/*"
            startActivityForResult(intent, PICK_VIDEO_REQUEST)
        }

        findViewById<Button>(R.id.btnConvert).setOnClickListener {
            videoUri?.let { uri ->
                convertVideoToAudio(uri)
            } ?: run {
                Toast.makeText(this, "يرجى اختيار فيديو أولاً", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_VIDEO_REQUEST && resultCode == Activity.RESULT_OK) {
            data?.data?.let { uri ->
                videoUri = uri
                Toast.makeText(this, "تم اختيار الفيديو", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun convertVideoToAudio(uri: Uri) {
        // هنا سيتم إضافة الكود لاستخراج الصوت
        Toast.makeText(this, "جارٍ تحويل الفيديو إلى صوت...", Toast.LENGTH_SHORT).show()
        
        // استخدم FFmpeg أو MediaExtractor
    }
}