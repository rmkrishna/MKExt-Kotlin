package `in`.mkext.ui

import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Patterns
import android.widget.EditText

/**
 * Created by muthu on 27/1/18.
 */
fun EditText.textWatcher(init: ZTextWatcher.() -> Unit) = addTextChangedListener(ZTextWatcher().apply(init))

class ZTextWatcher : TextWatcher {

    private var mBeforeTextChanged: ((CharSequence?, Int, Int, Int) -> Unit)? = null
    private var mOnTextChanged: ((CharSequence?, Int, Int, Int) -> Unit)? = null
    private var mAfterTextChanged: ((Editable?) -> Unit)? = null

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        mBeforeTextChanged?.invoke(s, start, count, after)
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        mOnTextChanged?.invoke(s, start, before, count)
    }

    override fun afterTextChanged(s: Editable?) {
        mAfterTextChanged?.invoke(s)
    }

    fun beforeTextChanged(listener: (CharSequence?, Int, Int, Int) -> Unit) {
        mBeforeTextChanged = listener
    }

    fun onTextChanged(listener: (CharSequence?, Int, Int, Int) -> Unit) {
        mOnTextChanged = listener
    }

    fun afterTextChanged(listener: (Editable?) -> Unit) {
        mAfterTextChanged = listener
    }

}

fun EditText.isEmpty() = text.toString().isNullOrBlank()

inline fun EditText.isValidEmail() = (!isEmpty() and Patterns.EMAIL_ADDRESS.matcher(text.toString()).matches())
inline fun EditText.isValidPhoneNumber() = (!isEmpty() and Patterns.PHONE.matcher(text.toString()).matches())
inline fun EditText.isValidPassword() = (!isEmpty() and (text.toString().length >= 6))
