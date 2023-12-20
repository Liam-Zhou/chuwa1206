package MavenProject_designPattern.singletone.egaer.enumWay;

/**
 * 最简单, 并且是唯一不会被破坏, 但是枚举的方式属于饿汉式, 有时候会浪费内存空间.
 *
 */
public enum Singleton {
    INSTANCE;
}
