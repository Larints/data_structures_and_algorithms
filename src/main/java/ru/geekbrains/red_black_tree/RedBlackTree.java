package ru.geekbrains.red_black_tree;


/**
 * @apiNote Реализация красно - черного дерева.
 * Каждый узел может быть либо черным, либо красным и иметь
 * двух потомков.
 * Корень всегда черный.
 * Дети красного узла обязательно черные.
 * Для частного случая - левостороннее красно - черное дерево
 * также применяется следующий критерий: красный узел может быть только левым
 * потомком.
 */
public class RedBlackTree {

    private Node root;

    /**
     * @param value - значение типа Integer для удобства восприятия ноды древа.
     * @return возврат значения типа BOOLEAN, характеризующий удалось ли добавить текущую ноду в древо,
     * или такая нода в древо уже находится.
     * @apiNote Метод добавления ноды в дерево.
     * Проверяем условия. Если корень не равен NULL
     * то, рекурсивно ищем позицию для входной ноды.
     * Выполняем ребалансировку корня. Устанавливаем цвет корня черный.
     * Возвращаем результат. Если корень NULL то просто записываем текущую ноду в корень.
     */
    public boolean addNode(int value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }


    /**
     * @param node  - в аргументах метода, нода, для выполнения рекурсивного вызова в дальнейшем.
     * @param value - значение типа int
     * @return - возвращает TRUE или FALSE в зависимости, от того, удалось ли добавить ноду, или нет.
     * @apiNote Проверяем значения. Если значение больше корня,
     * уходим вправо, если меньше корня, уходим влево.
     * Красим ноду в красный цвет. Проверяем цвет родителя. Если цвет
     * родителя черный, то всё хорошо. Если цвет родителя красный, то начинаем работать.
     * Если дядя красный, то перекрашиваем отца и дядю в черный, а деда в красный
     * (если не корень). Если не корень, то запускаем рекурсивно функцию от верхнего элемента.
     * Если дядя черный, то выполняем поворот. Если вставляемый элемент, левый, то выполняем левый поворот.
     * Если вставляемый элемент, правый, то выполняем правый поворот. Красим вершину в черный, а правую ноду в красный.
     */

    private boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    /**
     * @param node - Входная нода.
     * @return Возвращает правового ребенка, который станет корнем текущего поддерева.
     * @apiNote Метод реализующий малый правый поворот.
     * Действия идентичные левому повороту
     */
    private Node rightSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }


    /**
     * @param node Входная нода.
     * @return возвращает значение левого ребенка, который становится корнем поддерева.
     * @apiNote Метод реализующий малый левый поворот.
     * Присваиваем переменной левого ребенка, текущего левого ребенка входной ноды.
     * Присваиваем переменной значение ноды, являющимся правым ребенком, левого ребенка, текущей ноды.
     * Далее левый ребенок, текущей ноды, становится этой нодой.
     * Левым ребенком текущей ноды, становится переменная, в которую была записана нода (промежуточная нода)
     * Цвет левого ребенка, становится цветом текущей ноды.
     * Возвращаем значение левого ребенка.
     */
    private Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = node.leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    /**
     * @param node Входная нода, для преобразования.
     * @apiNote Метод смены цвета. Дети текущей ноды, становятся черными,
     * сама нода становится красной. Соблюдая правило красно - черного дерева,
     * у которого у красной ноды, должны обязательно быть два черных потомка.
     */

    private void colorSwap(Node node) {
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    /**
     * Метод описывающий балансировку дерева.
     * Записываем входящую ноду в переменную.
     * Определяем переменную типа boolean для определния, нуждается ли текущее поддерево в балансировке.
     * Реализуем через цикл DO WHILE.
     * Устанавливаем переменную в значение FALSE. И проверяем условия. Если правый ребенок текущей ноды не равен NULL
     * и цвет правового ребенка текущий ноды красный и левый ребенок текущей ноды не равен NULL или цвет левого ребенка
     * текущей ноды черный, то делаем ребалансировку и выполняем правый поворот.
     * Проверяем следующее условие. Если значение левого ребенка текущей ноды не равен NULL и цвет левого ребенка
     * красный и значение левого потомка, у левого ребенка не NULL и цвет левого потомка, у левого ребенка красный,
     * то выполняем левый поворот.
     * Проверяем следующее условие. Если значение левого ребенка текущей ноды не NULL, и цвет левого ребенка красный и
     * правый ребенок не NULL и цвет правого ребенка красный, то выполняем замену цвета.
     * Выполняем цикл до тех пор, пока значение переменной баланса - истино.
     *
     * @param node входная нода
     * @return возвращаем сбалансированное дерево.
     */
    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.rightChild != null && result.rightChild.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }

    private enum Color {
        RED, BLACK;
    }

    /**
     * @apiNote Класс NODE, инкапсулирующий в себя
     * значение типа int для удобства сравнения и балансировки дерева.
     * Цвет, обозначенный с помощью ENUM. Ссылка на левого ребенка и ссылка
     * на правового ребенка.
     */

    public class Node {

        private int value;

        private Color color;

        private Node leftChild;

        private Node rightChild;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", color=" + color +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }
}
