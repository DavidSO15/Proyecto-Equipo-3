import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.proyectoequipo3.FragmentCommunicator
import com.example.proyectoequipo3.MainActivity
import com.example.proyectoequipo3.R
import com.example.proyectoequipo3.databinding.FragmentFirstBinding
import com.example.proyectoequipo3.databinding.FragmentLoginBinding
import com.example.proyectoequipo3.databinding.FragmentRegisterBinding
import com.example.proyectoequipo3.viewmodel.loginViewModel

private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {


    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var communicator: FragmentCommunicator
    private val viewModel by viewModels<loginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        setupview()
        communicator=requireActivity() as FragmentCommunicator
        setupobservers()
        return binding.root
    }

    private fun setupobservers() {
        viewModel.isLoading.observe(viewLifecycleOwner){
            communicator.manageLoader(it)

        }
        viewModel.loginResult.observe(viewLifecycleOwner){
            val intent = Intent(activity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            activity?.finish()
        }
    }

    private fun setupview() {
        binding.loginButton.setOnClickListener{
            viewModel.loginUser(binding.loginEmail.text.toString(), binding.loginPassword.text.toString())
        }
        binding.registerLink.setOnClickListener{
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

}