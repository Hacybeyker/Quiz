package com.hacybeyker.quiz.ui.home.fragment.level.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hacybeyker.quiz.R
import com.hacybeyker.quiz.databinding.RecyclerLevelBinding
import com.hacybeyker.quiz.domain.entity.LevelEntity
import kotlin.math.roundToInt

class LevelAdapter(
    private val onClick: (LevelEntity) -> Unit
) : ListAdapter<LevelEntity, LevelAdapter.LevelViewHolder>(LevelDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelViewHolder {
        return LevelViewHolder.from(parent, onClick)
    }

    override fun onBindViewHolder(holder: LevelViewHolder, position: Int) {

        holder.bind(getItem(position))
    }

    override fun submitList(list: MutableList<LevelEntity>?) {
        super.submitList(list)
    }

    class LevelViewHolder(
        private val binding: RecyclerLevelBinding,
        private val onClick: (LevelEntity) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(
                parent: ViewGroup,
                onClick: (LevelEntity) -> Unit
            ): LevelViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecyclerLevelBinding.inflate(layoutInflater, parent, false)
                return LevelViewHolder(binding, onClick)
            }
        }

        fun bind(item: LevelEntity) {
            with(binding) {
                tvLevelCategory.text = item.category
                tvLevelDescription.text = item.description
                ivLevelImage.setImageResource(item.image)
                tvLevelName.text = item.name

                if (item.isDisable) {
                    mcLevel.setCardForegroundColor(
                        ColorStateList.valueOf(
                            getColorWithAlpha(
                                color = root.resources.getColor(
                                    R.color.black,
                                    root.context.theme
                                ),
                                ratio = 0.35f
                            )
                        )
                    )
                } else {
                    mcLevel.setOnClickListener { onClick(item) }
                }

                if (item.isComplete) {
                    tvLevelTime.text = HtmlCompat.fromHtml(
                        String.format(
                            root.context.getString(R.string.level_result_time),
                            "1:35"
                        ),
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    )

                    tvLevelStatistics.text = HtmlCompat.fromHtml(
                        String.format(
                            root.context.getString(R.string.level_result_statistics),
                            "7",
                            "3"
                        ),
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                    )
                    clLevelResultContainer.visibility = View.VISIBLE
                }
            }
        }

        private fun getColorWithAlpha(color: Int, ratio: Float): Int {
            return Color.argb(
                (Color.alpha(color) * ratio).roundToInt(),
                Color.red(color),
                Color.green(color),
                Color.blue(color)
            )
        }
    }
}
