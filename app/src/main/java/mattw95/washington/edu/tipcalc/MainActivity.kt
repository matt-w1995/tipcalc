package mattw95.washington.edu.tipcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Toast
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listOfTips = arrayOf(10.0, 15.0, 18.0, 20.0)
        val arrayAdapter = ArrayAdapter<Double>(this, android.R.layout.simple_spinner_item, listOfTips)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnTipAmount.adapter = arrayAdapter

        btnTip.isEnabled = false
        btnTip.setOnClickListener {
            var percentage = spnTipAmount.selectedItem as Double
            percentage /= 100
            val value: String = (txtAmount.text).toString()
            val dblValue: Double = value.toDouble() * percentage

            Toast.makeText(this, ("$" + "%.2f".format(dblValue)), Toast.LENGTH_LONG).show()
        }
        
        txtAmount.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btnTip.isEnabled = true
            }

        })


    }
}
