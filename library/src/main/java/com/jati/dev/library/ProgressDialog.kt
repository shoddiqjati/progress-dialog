package com.jati.dev.library

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.jati.dev.library.R.id.tv_message

/**
 * Created by shoddiq on 12/02/18.
 */

class ProgressDialog : AlertDialog {

    private var message: CharSequence? = null

    class Builder {
        private var context: Context? = null
        private var message: String? = null
        private var messageId: Int = 0
        private var cancelable = true

        fun setContext(context: Context): Builder {
            this.context = context
            return this
        }

        fun setMessage(message: String): Builder {
            this.message = message
            return this
        }

        fun setMessage(messageId: Int): Builder {
            this.messageId = messageId
            return this
        }

        fun setCancelable(cancelable: Boolean): Builder {
            this.cancelable = cancelable
            return this
        }

        fun build(): AlertDialog {
            return ProgressDialog(
                    context!!,
                    if (messageId != 0) context?.getString(messageId) ?: "" else message!!,
                    cancelable)
        }

    }

    protected constructor(context: Context) : super(context)

    private constructor(context: Context, message: String, cancelable: Boolean) : super(context) {
        this.message = message
        setCancelable(cancelable)
        setCanceledOnTouchOutside(cancelable)
    }

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_progress)
        setCanceledOnTouchOutside(false)

        initMessage()
    }

    override fun setMessage(message: CharSequence) {
        super.setMessage(message)
        if (isShowing) initMessage()
    }

    private fun initMessage() {
        if (message != null) {
            tv_message
        }
    }
}
