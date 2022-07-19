package com.hacybeyker.quiz.ui.game.fragment

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.hacybeyker.quiz.R
import com.hacybeyker.quiz.databinding.FragmentQuestionBinding
import com.hacybeyker.quiz.domain.entity.AnswerEntity

class QuestionFragment : Fragment() {

    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!

    private val questionVO = arrayListOf<QuestionVO>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val answers = arrayListOf(
            AnswerEntity(
                1, "Orange"
            ),
            AnswerEntity(
                2, "Banana"
            ),
            AnswerEntity(
                3, "Apple", true
            )
        )

        for (item in answers) {
            //val testSignIn = MaterialButton(requireContext())
            val testSignIn =
                MaterialButton(requireContext(), null, R.attr.buttonBarPositiveButtonStyle)
            val buttonText = item.title
            testSignIn.id = item.id
            testSignIn.text = buttonText
            testSignIn.insetTop = 20
            testSignIn.isCheckable = true
            testSignIn.cornerRadius = 60
            testSignIn.strokeWidth = 8
            testSignIn.strokeColor = ColorStateList.valueOf(
                requireContext().resources.getColor(
                    R.color.teal_200,
                    requireContext().theme
                )
            )
            testSignIn.textSize = 16.0f
            testSignIn.typeface =
                ResourcesCompat.getFont(requireContext(), R.font.montserrat_normal)
            testSignIn.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                140
            )
            testSignIn.setOnClickListener {
                verify2(testSignIn)
            }
            binding.vAnswers.addView(testSignIn)
            questionVO.add(QuestionVO(item, testSignIn))
        }
    }

    private fun verify(answer: AnswerEntity, view: View) {
        val algo = binding.vAnswers.childCount - 1
        for (al in 0..algo) {
            val button = binding.vAnswers.getChildAt(al) as MaterialButton
            button.isChecked = false
        }
        (view as MaterialButton).isChecked = true
    }

    private fun verify2(button: MaterialButton) {
        questionVO.map { it.button.isChecked = false }
        button.isChecked = true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}