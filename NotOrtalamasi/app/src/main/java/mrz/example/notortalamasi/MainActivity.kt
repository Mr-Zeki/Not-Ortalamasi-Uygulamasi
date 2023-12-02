package mrz.example.notortalamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mrz.example.notortalamasi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val mainBinding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this@MainActivity,R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding.Hesapla.setOnClickListener{
            val birincinot : String = mainBinding.birinciNot.text.toString()
            val ikincinot : String = mainBinding.ikinciNot.text.toString()
            val gecerNot : Int = 45
            val maxNot : Int = 100
            val minNot : Int = 0
            var toplamNot : String = ""

            if(mainBinding.birinciNot.text.toString().isEmpty() || birincinot.toInt()>maxNot || birincinot.toInt()<minNot){
                mainBinding.birinciNot.error = "Hatalı İşlem Yaptınız"
            }
            else if(mainBinding.ikinciNot.text.toString().isEmpty() || ikincinot.toInt()>maxNot || ikincinot.toInt()<minNot){
                mainBinding.ikinciNot.error = "Hatalı İşlem Yaptınız"
            }
            else {
                mainBinding.notOrt = ((birincinot.toInt()+ikincinot.toInt())/2).toString()

                toplamNot = mainBinding.notOrt.toString()
                    if (toplamNot.toInt()<gecerNot){
                        mainBinding.notSonucu = "Kaldınız"
                    }
                else {
                        mainBinding.notSonucu = "Geçtiniz"
                    }

            }
        }
    }
}