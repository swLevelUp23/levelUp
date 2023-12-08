package engine;

/**
 * Implements an object that stores a single game's difficulty settings.
 * 
 * @author <a href="mailto:RobertoIA1987@gmail.com">Roberto Izquierdo Amo</a>
 * 
 */
public class GameSettings {

	/** Width of the level's enemy formation. */
	private int formationWidth;
	/** Height of the level's enemy formation. */
	private int formationHeight;
	/** Speed of the enemies, function of the remaining number. */
	private int baseSpeed;
	/** Frequency of enemy shootings, +/- 30%. */
	private int shootingFrecuency;
	/** Speed of item dropping. */
	private double itemSpeed;
	/** Check if the stage is boss stage. */
	private boolean BossStage;
	/** 아이템의 발생 빈도
	 * 레벨 0에서는 무조건 발생하도록 true
	 * 나머지 레벨에서는 랜덤으로 발생하도록 false */
	private boolean itemPro;
	/**
	 * Constructor.
	 * 
	 * @param formationWidth
	 *            Width of the level's enemy formation.
	 * @param formationHeight
	 *            Height of the level's enemy formation.
	 * @param baseSpeed
	 *            Speed of the enemies.
	 * @param shootingFrecuency
	 *            Frecuency of enemy shootings, +/- 30%.
	 */
	public GameSettings(final int formationWidth, final int formationHeight,
			final int baseSpeed, final int shootingFrecuency, final double itemSpeed) {
		this.formationWidth = formationWidth;
		this.formationHeight = formationHeight;
		this.baseSpeed = baseSpeed;
		this.shootingFrecuency = shootingFrecuency;
		this.itemSpeed = itemSpeed;
		this.BossStage = false;
	}

	public GameSettings(final int formationWidth, final int formationHeight,
						final int baseSpeed, final int shootingFrecuency, final double itemSpeed, final boolean boss) {
		this.formationWidth = formationWidth;
		this.formationHeight = formationHeight;
		this.baseSpeed = baseSpeed;
		this.shootingFrecuency = shootingFrecuency;
		this.itemSpeed = itemSpeed;
		this.BossStage = true;
	}


	/**
	 * @return the formationWidth
	 */
	public final int getFormationWidth() {
		return formationWidth;
	}

	/**
	 * @return the formationHeight
	 */
	public final int getFormationHeight() {
		return formationHeight;
	}

	/**
	 * @return the baseSpeed
	 */
	public final int getBaseSpeed() {
		return baseSpeed;
	}

	/**
	 * @return the shootingFrecuency
	 */
	public final int getShootingFrecuency() {
		return shootingFrecuency;
	}

	/** 폭탄 투하 빈도 */
	public final int getDropFrecuency() { return shootingFrecuency + 1000; }
	public final boolean getItemPro() { return itemPro; }

	public final boolean checkBoss() { return this.BossStage; }
}
