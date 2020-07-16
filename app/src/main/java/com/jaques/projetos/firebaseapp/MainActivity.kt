package com.jaques.projetos.firebaseapp


import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.firebase.ui.storage.images.FirebaseImageLoader
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream


class MainActivity : AppCompatActivity() {

    //    private val referencia: DatabaseReference = FirebaseDatabase.getInstance().getReference()
//    private val usuario: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var imageFoto: ImageView;
    private lateinit var buttonUpload: Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonUpload = buttonActivity_Upload
        imageFoto = imageActivityFoto

        buttonUpload.setOnClickListener(OnClickListener {

//            // Get the data from an ImageView as bytes
//            val bitmap = (imageFoto.drawable as BitmapDrawable).bitmap
//            val baos = ByteArrayOutputStream()
//
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 75, baos)
//            val dadosImagemm = baos.toByteArray()
//            val storageReference = FirebaseStorage.getInstance().reference
            Toast.makeText(applicationContext, "Pressed", Toast.LENGTH_SHORT).show()


          val imageref = Firebase.storage.reference.child("imagens/celular.jpg")
            imageref.downloadUrl.addOnSuccessListener {Uri->

                val imageURL = Uri.toString()
                imageFoto = findViewById(R.id.imageActivityFoto)
                Glide.with(this)
                    .load(imageURL)
                    .into(imageFoto)

            }

            Toast.makeText(applicationContext, "pass", Toast.LENGTH_SHORT).show()

//            val imagens = storageReference.child("imagens")
//            val imageRef = imagens.child("celular.jpg")

            /* imageRef.delete().addOnSuccessListener {

                 Toast.makeText(applicationContext, "Imagem deletada com sucesso", Toast.LENGTH_LONG)
                     .show()
             }.addOnFailureListener {
                 Toast.makeText(applicationContext, " Falha ao deletar a imagem", Toast.LENGTH_LONG)
                     .show()
             }
             */


            // Name of image
//            val nameFile = UUID.randomUUID().toString()
//            val imageRef = imagens.child("imagens/celular.jpg")


//            val uploadTask = imageRef.putBytes(dadosImagemm)
            /*uploadTask.addOnFailureListener {
                 Toast.makeText(
                     applicationContext,
                     "Upload da imagem falhou: ${it.message.toString()}",
                     Toast.LENGTH_LONG
                 ).show()
             }.addOnSuccessListener { task ->
 //                taskSnapshot.getMetadata().getReference().getDownloadUrl().toString()
                 val downloadURL = task.metadata?.reference?.downloadUrl.toString()
 //                val downloadUri = uploadTask.result
                 Toast.makeText(
                     applicationContext,
                     "Upload da imagem com sucesso:  ${downloadURL}",
                     Toast.LENGTH_LONG
                 ).show()
             }*/
        })


//        val usuarios = referencia.child("usuarios")

//        val usuarioPesquisa = usuarios.child("-MC3fqULk9-34c8njGTM")
//        val usuarioPesquisa = usuarios.orderByChild("nome").equalTo("Jamilton")
//        val usuarioPesquisa = usuarios.orderByKey().limitToLast(3)
        /*Biger or equal ( >= )
        val usuarioPesquisa = usuarios.orderByChild("idade").startAt(35.0)*/

        /* Minus or equal ( <= )
        val usuarioPesquisa = usuarios.orderByChild("idade").endAt(22.0)*/

        /* Between ( >= &&  <=  )
        val usuarioPesquisa = usuarios.orderByChild("idade")
            .startAt(18.0).endAt(30.0)*/

        /* Filter words
        val usuarioPesquisa = usuarios.orderByChild("nome").startAt("J").endAt("J" + "\uf8ff")

        usuarioPesquisa.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                        TODO("Not yet implemented")
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                val dadosUsuario = dataSnapshot.getValue(Usuario::class.java)
//                Log.i("Dados do usuario ", "nome: ${dadosUsuario!!.nome} idade: ${dadosUsuario!!.idade} ")
                Log.i("Dados do usuario: ", dataSnapshot.value.toString())
            }

        });*/

/*
        val usuario = Usuario("Rodrigo","Matos", 35 )
        usuarios.push().setValue(usuario)

        //Exit login
        usuario.signOut()

//Check user login
        if(usuario.currentUser != null) Log.i(
            "CurrentUser","Success user login") else Log.i(
            "CurrentUser","User not login ")

//Login User
//        usuario.signInWithEmailAndPassword(
            "leonardojaquesads@gmail.com","leo12345").addOnCompleteListener{
            if (it.isSuccessful) Log.i(
                "signInUser","Success in login the user") else
                Log.i(
                "signInUser","Error in login the user")
        }
*/

//Register user
/*usuario.createUserWithEmailAndPassword(
    "leonardojaquesads2@gmail.com","leo12345").addOnCompleteListener {
    if (it.isSuccessful) Log.i(
        "CreateUser","Success in registering the user") else Log.i(
            "CreateUser","Error in registering the user")
}*/


/*
//salvando dados no firebase
val usuario = Usuario("Soraya","Jaques", 34 )
val produto = Produto("Smartphone", "Sansung", 4184.07)

val usuarios = referencia.child("usuarios")
usuarios.child("002").setValue(usuario)
val produtos = referencia.child("produtos")
produtos.child("001").setValue(produto)

usuarios.addValueEventListener(object : ValueEventListener{
    override fun onCancelled(databaseError: DatabaseError) {
//        TODO("Not yet implemented")
    }

    override fun onDataChange(dataSnapshot: DataSnapshot) {
        Log.i("FIREBASE",dataSnapshot.value.toString())
    }
})

*/
    }
}
