package com.javokhirbekcoder.shevalugati.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.javokhirbekcoder.shevalugati.ItemModel
import com.javokhirbekcoder.shevalugati.MainAdapter
import com.javokhirbekcoder.shevalugati.R
import com.javokhirbekcoder.shevalugati.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MainAdapter
    private var list = ArrayList<ItemModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater)

//        list.add(ItemModel("soz", "manosi"))

        val words = """
            Ännapida
            Ärjänäk
            Äptada
            Äsïräk
            Äsväk
            Batmannin
            Bäräk
            Baldïz
            Bad-bad
            Bajäqï
            Dalan
            Dajav
            Dïγïrïq
            Doča
            Dunäk
            Ertäŋ
            Ešäkarï
            Eläštïrmaq
            Eǯašmaq
            Ergänäk
            Gäzïk
            Gečča
            Guriŋ
            Guldïrmämä
            Gäšïr
            Häkäk
            Häzlik
            Happïqmaq
            Havlaqï
            Hasakï
            Ilmäk
            Išqïrmaq
            Ilïštïrik
            Ič qïsmaq
            Ǯalataj
            Ǯïrpïq
            Ǯallï
            Kädï
            Kälčik
            Käläsäŋ
            Kämïs-kȕtïk
            Lappa
            Laplama
            Labïrdamaq
            Labzinä
            Malamïǯïr
            Marqa
            Mäzi
            Mayrïq
            Mïǯǯïldöq
            Namäzšäm
            Sïmtïq
            Qaraqäzän
            Qajïš
            Qapïlmäq
            Pïsqïmaq
            Patrat
            Pajïr
            Otläštïrmäk
            Oǯäk
            Našvatï
            Šappat
            Šïmbïl
            Čökïĉ
            Päjäpol
            pompä
            Pïlïk
            Peš
            Qošānt
            Qütarmaq
            Qondāq
            Qoŋïšï
            Rädi
            Ramazan
            Räsïm
            Räpidä
            Ullaj
            űttik
            shunni
            űstä 
            uǯï
            űčäk
            nah
            zamča
            ӧljabuva
            qapï
            säŋ:ï
            sïplik
            et
            atïz
            qajïn bikä
             baldïz
            pejkal
            ǯügärï
            šappattin
            čӧkïš
            čommïq
            čoqačijan
            dimä
            gӧz
            gӧjnäk
            peda
            änäqutï
            patja
            paraxat
            läjän
            dïnnaq
            is
            salma
            pïttä
            ǯïmsï
            istädïm
            nāhunā
            čuγïl
            čolïq
            ahtïq
            čäj:a
            čäkäčandïr
            čäkidä
            čijin
            čijä
            čoqaq
            čiγ
            čïqān
            čïqqïnǯï
            čalur
            čaqïrïšma
            bana
            čïtnap-čïtnap
            čäkälämäk
            čačavladi
            čašmaq
            etjaǯi
            pïšik
            dïmïqdï
            kädï
            saŋaraq
            qara alï
            isïrγa
            jüzik
            qajš
            kisä
            innä
            ǯälläpkä
            mïnnï asmanda// mïnnï kütärïlmäk
            jaqalašmaq
            äpäšläš
            gӧjïnǯäk
            gälǯäk
            gӧrïšǯäk
            äsïrdï
            čӧräk
            šappat
            šapïrmaq
            zamarïq
            imänädï
            noqan
            sӧvdï
            Zaqqum
            qïzγanč
            jeγlaq
            osïn
            bijï
            üstär
            ojmaq
            sïpsä
            sanǯaq
            γālï
            kürt
            kasa
            qastinkä
            nӧš pijaz
            čapaq
            tälikä
            joγïč
            platinsa
            ataqarva
            güpsï
            jāvā
            qajïnnä
            qalïŋ
            kätxuda
            jalïŋ
            kätxuda
            jalïŋ
    """.trimIndent()

        val means = """
 unobi mevasi 
 to‘siq, panjara 
 juda eski 
 o‘ta dimog‘dor odam 
 suvni yig‘ib , dalalarga yuboradigan yer 
 juda katta, baland 
 ovqat turi, chuchvara 
 kuyovning singlisi 
 köp gäpiruvči 
 avvalgidek, o‘zgarmagan 
 uyning doimiy o‘tiriladigan qismi 
 baquvvat, dag‘al inson 
 tor ko‘cha,jin ko‘cha 
 dovuchcha, pishmagan o‘rik 
 hali pishmagan qovun 
 ertaga 
 qovog‘ari 
 aybga buyurmaslik 
 o‘chakishmoq 
 to‘siq, g‘ov 
 gal, navbat 
 gapga tushunmaydigan odam 
 suhbat, g‘iybat 
 momoqaldiroq 
 sabzi 
 zag‘izg‘on 
 mazza, yoqimli 
 dimiqmoq 
 hovliquvchan 
 nimjon 
 ilib qo’yish uchun ishlatiladi 
 xushtak chalmoq 
 do‘lana 
 zerikmoq 
 yomon, ko’p gapiradigan ayollarga nisbatan ishlatiladi 
 satang, tannoz 
 yaxshi, zo’r 
 qovoq 
 duduq 
 bolani uyqudan erta uyg’otib, mudroq holga keltirish 
 kam ko’st
 shartta 
 rang-barang
 ko’p gapirmoq 
 pashmak holva 
 tushunarsiz, mujmal 
 oppoq ayollarga nisbatan ishlatiladigan so’z 
 bekorga, bekordan 
 oyog’ini oqsab oladigan, mayib 
 juda ham e’tiborli, ko’p xato topadigan 
 asr va shomni orasi 
 juda bo’sh, hech narsa qo’lidan kelmaydigan 
 qattiq sovuq 
 kamar 
 gapirmaslik, indamaslik 
 changib ketmoq 
 janjal, mojaro 
 xamirturush 
 zo‘raytirmoq, kuchaytirmoq 
 buzoq, sigirning bolasi 
 nok
 tarsaki 
 hech narsa, hech nima
 bolg’a
 ariqni kesib o‘tish uchun ko‘prik. 
 nasos.
 yonuvchi cho’p.
 pech.
 yordam.
 tugatmoq.
 yoʻrgak.
 qoʻshni.
 radio.Ovozni uzoq masofalarga elektromagnit toʻlqinlar tarzida simsiz uzatish va qabul qilish vositalari majmui.
 ramazon. Qamariya hisobida toʻqqizinchi oyning arabcha nomi. (bu oyda musulmonlar ro’za tutadilar).
 rasm. Qoʻlda chizilgan, bosma yoki fotografik tasvir, surat.
 rapida.Tandirga non yopish uchun ishlatiladigan, matodan tikilgan qalin tikilgan to’garak shakldagi asbob.
 katta boʻlmoq.
 dazmol.
 mana shunaqa.
 stol.
 Biror narsaning uch tomoni.
 tom. 
 ip
 handalak
 qabriston
 eshik
 daydi
 axlat, supurindi
 go‘sht
 dala
 qayin opa
 qayin singil
 jarchi
 jo‘xori
 kichkina
 bolg‘a
 cho‘ltoq, to‘mtoq
 qo‘pol, qo‘rs
 tugma
 ko‘z
 ko‘ylak
 foyda
 gapga suqulaveradigan
 fotiha
 tinch
 tog‘ora
 tirnoq
 hid
 ariq
 foyda
 injiq
 sog‘indim
 ko‘r
 chaqimchi
 chevara
 nabira
 qum
 tirishqoq, bir ishga astoydil yonndashadigan
 sut mahsuloti, suzma
 kurmak
 olcha
 badjahl, qo‘pol
 shudring
 dugona
 sarf-harajat
 shim
 kelin chaqiriq, ziyofat
 buyon(Yuklama)
 chertib-chertib
 tortqilamoq
 shovqin soldi, janjal qildi
 o‘zidan ketmoq, es-xushini yo‘qotmoq
 har ehtimolga qarshi
 mushuk
 nafas yetmay qoldi
 qovoq
 danak
 olxo‘ri
 zirak
 uzuk
 kamar
 cho‘ntak
 igna
 nimcha
 o‘zini osmon tutmoq, kerilmoq
 urushmoq, janjallashmoq, yoqa tirtishmoq
 avaylash, asrash
 kuyunchak
 kelmoqchi
 ko‘rishmoq
 o‘zidan ketdi
 kichik non, kulcha
 tarsaki
 o‘rinsiz sarflamoq
 qo‘ziqorin
 yegisi kelmoq, talpinmoq
 ipak  qurti
 erkaladi
 zahar
 qizg‘anchiq
 yig‘loqi
 ovsin
 kelinoyi
 xontaxta
 angishvona
 supurgi
 arg‘imchoq
 gilam
 gugurt
 piyola
 ro‘mol
 yumshoq, mayin piyoz
 chopqi
 likopcha
 jova
 sochiq
 yosh bolan yurishga o‘rgatadigan uch g‘idirakli arava
 ombur
 uch tishli yog‘och panshax
 qaynona
 qalin puli
 hech kimga gap bermaydigan, gap bilan hammani yengishga harakat qiladigan odam
 issiq shamol
 hech kimga gap bermaydigan, gap bilan hammani yengishga harakat qiladigan odam
 issiq shamol
        """.trimIndent()

        val wordList = words.split("\n").filter { it.isNotBlank() }
        val meansList = means.split("\n").filter { it.isNotBlank() }

        for (i in wordList.indices) {
            list.add(ItemModel(wordList[i] + " -", meansList[i]))
        }

        adapter = MainAdapter(list)
        binding.mainRecycler.adapter = adapter


        binding.qidiruvEt.addTextChangedListener { text ->
            adapter.filter.filter(text)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}