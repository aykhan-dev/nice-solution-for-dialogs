package ev.aykhn.demo

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import ev.aykhn.demo.databinding.DialogExampleBinding

class ExampleDialog private constructor() : DialogFragment() {

    companion object {

        const val TAG = "Example Dialog TAG"

        fun newInstance(
            onAccept: () -> Unit,
            onCancel: () -> Unit
        ): ExampleDialog {
            return ExampleDialog().apply {
                this.onAccept = onAccept
                this.onCancel = onCancel
            }
        }

    }

    private var binding: DialogExampleBinding? = null

    private var onAccept: (() -> Unit)? = null
    private var onCancel: (() -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return DialogExampleBinding.inflate(inflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI()
    }

    override fun onStart() {
        super.onStart()
        dialog?.let {
            val metrics = activity?.displayMetrics ?: return@let
            val width = metrics[0] * 0.7f
            val height = width / 1.5f
            it.window?.setLayout(width.toInt(), height.toInt())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun bindUI() {

        binding?.let { ui ->

            ui.buttonCancel.setOnClickListener {
                onCancel?.invoke()
                dismiss()
            }

            ui.buttonAccept.setOnClickListener {
                onAccept?.invoke()
                dismiss()
            }

        }

    }

}