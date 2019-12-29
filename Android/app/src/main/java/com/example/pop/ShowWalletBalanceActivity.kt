package com.example.pop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pop_sajamv2.Session
import com.example.webservice.Common.Common
import com.example.webservice.Model.ProductResponse
import com.example.webservice.Model.WalletBalanceResponse
import kotlinx.android.synthetic.main.activity_show_wallet_balance.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowWalletBalanceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_wallet_balance)
        getBalance()
        refreshWalletBallance.setOnRefreshListener {
            getBalance()
            refreshWalletBallance.isRefreshing = false
        }
        btn_details.setOnClickListener{}
    }

    private fun getBalance(){
        val api = Common.api
        api.getWalletBalance(Session.user.Token, true, Session.user.KorisnickoIme).enqueue(object : Callback<WalletBalanceResponse>{
            override fun onFailure(call: Call<WalletBalanceResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<WalletBalanceResponse>,
                response: Response<WalletBalanceResponse>
            ) {
                walletBalance.text = response.body()!!.DATA + " HRK"
            }
        })
    }
}
