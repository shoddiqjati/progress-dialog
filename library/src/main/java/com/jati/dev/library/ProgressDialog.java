package com.jati.dev.library;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;

/**
 * Created by shoddiq on 12/02/18.
 */

public class ProgressDialog extends AlertDialog {

    public static class Builder {
        private Context context;
        private String message;
        private int messageId;
        private boolean cancelable = true;

        public Builder setContext(@NonNull Context context) {
            this.context = context;
            return this;
        }

        public Builder setMessage(@NonNull String message) {
            this.message = message;
            return this;
        }

        public Builder setMessage(int messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public AlertDialog build() {
            return new ProgressDialog(
                    context,
                    messageId != 0 ? context.getString(messageId) : message,
                    cancelable);
        }

    }

    private CharSequence message;

    protected ProgressDialog(@NonNull Context context) {
        super(context);
    }

    private ProgressDialog(@NonNull Context context, String message, boolean cancelable) {
        super(context);
        this.message = message;
        setCancelable(cancelable);
        setCanceledOnTouchOutside(cancelable);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_progress);
        setCanceledOnTouchOutside(false);

        initMessage();
    }

    @Override
    public void setMessage(CharSequence message) {
        super.setMessage(message);
        if (isShowing()) initMessage();
    }

    private void initMessage() {
        if (message != null) {
            if (findViewById(R.id.tv_message) != null) {
                ((TextView) findViewById(R.id.tv_message)).setText(message);
            }
        }
    }
}
