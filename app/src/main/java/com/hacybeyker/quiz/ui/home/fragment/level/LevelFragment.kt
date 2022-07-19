package com.hacybeyker.quiz.ui.home.fragment.level

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import com.hacybeyker.quiz.R
import com.hacybeyker.quiz.databinding.FragmentLevelBinding
import com.hacybeyker.quiz.domain.entity.AnswerEntity
import com.hacybeyker.quiz.domain.entity.LevelEntity
import com.hacybeyker.quiz.domain.entity.QuestionEntity
import com.hacybeyker.quiz.domain.entity.StatisticsEntity
import com.hacybeyker.quiz.ui.game.GameActivity
import com.hacybeyker.quiz.ui.home.fragment.level.adapter.LevelAdapter

class LevelFragment : Fragment() {

    private var _binding: FragmentLevelBinding? = null
    private val binding get() = _binding!!

    private val levelAdapter: LevelAdapter by lazy { LevelAdapter { onClickLevel(it) } }

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("ARG_PARAM1")
            param2 = it.getString("ARG_PARAM2")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvLevels.adapter = levelAdapter
            rvLevels.setHasFixedSize(true)
            rvLevels.itemAnimator = DefaultItemAnimator()
            levelAdapter.submitList(
                arrayListOf(
                    LevelEntity(
                        1,
                        "Level 1",
                        "Fruits",
                        R.drawable.icon_fruit,
                        "Aprenderás la traduccion de algunas frutas.",
                        true,
                        false,
                        true,
                        statisticsEntity = StatisticsEntity(7, 3, 10, "1:45"),
                        questions = arrayListOf(
                            QuestionEntity(
                                1, "Como se dice manzana en ingles?", answers = arrayListOf(
                                    AnswerEntity(
                                        1, "Orange"
                                    ),
                                    AnswerEntity(
                                        2, "Banana"
                                    ),
                                    AnswerEntity(
                                        3, "Apple", true
                                    ),
                                )
                            ),
                            QuestionEntity(
                                1, "Como se dice naranja en ingles?", answers = arrayListOf(
                                    AnswerEntity(
                                        1, "Orange", true
                                    ),
                                    AnswerEntity(
                                        2, "Banana"
                                    ),
                                    AnswerEntity(
                                        3, "Apple"
                                    ),
                                )
                            )
                        )
                    ),
                    LevelEntity(
                        2,
                        "Level 2",
                        "Family",
                        R.drawable.icon_family,
                        "Aprenderás la traduccion de algunos miembros de la familia",
                        true,
                        false,
                        false,
                        statisticsEntity = null,
                        questions = arrayListOf(
                            QuestionEntity(
                                1, "Como se dice manzana en ingles?", answers = arrayListOf(
                                    AnswerEntity(
                                        1, "Orange"
                                    ),
                                    AnswerEntity(
                                        2, "Banana"
                                    ),
                                    AnswerEntity(
                                        3, "Apple", true
                                    ),
                                )
                            ),
                            QuestionEntity(
                                1, "Como se dice naranja en ingles?", answers = arrayListOf(
                                    AnswerEntity(
                                        1, "Orange", true
                                    ),
                                    AnswerEntity(
                                        2, "Banana"
                                    ),
                                    AnswerEntity(
                                        3, "Apple"
                                    ),
                                )
                            )
                        )
                    ),
                    LevelEntity(
                        3,
                        "Level 3",
                        "Numbers",
                        R.drawable.icon_number,
                        "Aprenderás la traduccion de algunos numeros.",
                        true,
                        statisticsEntity = null,
                        questions = arrayListOf(
                            QuestionEntity(
                                1, "Como se dice manzana en ingles?", answers = arrayListOf(
                                    AnswerEntity(
                                        1, "Orange"
                                    ),
                                    AnswerEntity(
                                        2, "Banana"
                                    ),
                                    AnswerEntity(
                                        3, "Apple", true
                                    ),
                                )
                            ),
                            QuestionEntity(
                                1, "Como se dice naranja en ingles?", answers = arrayListOf(
                                    AnswerEntity(
                                        1, "Orange", true
                                    ),
                                    AnswerEntity(
                                        2, "Banana"
                                    ),
                                    AnswerEntity(
                                        3, "Apple"
                                    ),
                                )
                            )
                        )
                    ),
                    LevelEntity(
                        4,
                        "Level 4",
                        "Seasons",
                        R.drawable.icon_season,
                        "Aprenderás la traduccion de algunas estaciones.",
                        true,
                        statisticsEntity = null,
                        questions = arrayListOf(
                            QuestionEntity(
                                1, "Como se dice manzana en ingles?", answers = arrayListOf(
                                    AnswerEntity(
                                        1, "Orange"
                                    ),
                                    AnswerEntity(
                                        2, "Banana"
                                    ),
                                    AnswerEntity(
                                        3, "Apple", true
                                    ),
                                )
                            ),
                            QuestionEntity(
                                1, "Como se dice naranja en ingles?", answers = arrayListOf(
                                    AnswerEntity(
                                        1, "Orange", true
                                    ),
                                    AnswerEntity(
                                        2, "Banana"
                                    ),
                                    AnswerEntity(
                                        3, "Apple"
                                    ),
                                )
                            )
                        )
                    ),
                    LevelEntity(
                        5,
                        "Level 5",
                        "Careers",
                        R.drawable.icon_career,
                        "Aprenderás la traduccion de algunas carreras.",
                        true,
                        statisticsEntity = null,
                        questions = arrayListOf(
                            QuestionEntity(
                                1, "Como se dice manzana en ingles?", answers = arrayListOf(
                                    AnswerEntity(
                                        1, "Orange"
                                    ),
                                    AnswerEntity(
                                        2, "Banana"
                                    ),
                                    AnswerEntity(
                                        3, "Apple", true
                                    ),
                                )
                            ),
                            QuestionEntity(
                                1, "Como se dice naranja en ingles?", answers = arrayListOf(
                                    AnswerEntity(
                                        1, "Orange", true
                                    ),
                                    AnswerEntity(
                                        2, "Banana"
                                    ),
                                    AnswerEntity(
                                        3, "Apple"
                                    ),
                                )
                            )
                        )
                    ),
                    LevelEntity(
                        6,
                        "Level 6",
                        "Calendar",
                        R.drawable.icon_calendar,
                        "Aprenderás la traduccion de los meses.",
                        true,
                        statisticsEntity = null,
                        questions = arrayListOf(
                            QuestionEntity(
                                1, "Como se dice manzana en ingles?", answers = arrayListOf(
                                    AnswerEntity(
                                        1, "Orange"
                                    ),
                                    AnswerEntity(
                                        2, "Banana"
                                    ),
                                    AnswerEntity(
                                        3, "Apple", true
                                    ),
                                )
                            ),
                            QuestionEntity(
                                1, "Como se dice naranja en ingles?", answers = arrayListOf(
                                    AnswerEntity(
                                        1, "Orange", true
                                    ),
                                    AnswerEntity(
                                        2, "Banana"
                                    ),
                                    AnswerEntity(
                                        3, "Apple"
                                    ),
                                )
                            )
                        )
                    )
                ).filter { it.isShow }.toMutableList()
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LevelFragment().apply {
                arguments = Bundle().apply {
                    putString("ARG_PARAM1", param1)
                    putString("ARG_PARAM2", param2)
                }
            }
    }

    private fun onClickLevel(level: LevelEntity) {
        Log.d("TAG", "Here - onClickLevel: $level")
        this.startActivity(Intent(requireActivity(), GameActivity::class.java))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
