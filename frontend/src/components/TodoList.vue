<template>
  <section>
    <!--리스트 부분 -->
    <transition-group name="list" tag="ul"> <!--transition-group으로 애니메이션 처리-->
      <li v-for="(todoItem, index) in propsdata" :key="todoItem" class="shadow">
        <i class="checkBtn fas fa-check" aria-hidden="true"></i>
          {{ todoItem }}
        <span class="removeBtn" type="button" @click="removeTodo(todoItem, index)">
          <i class="far fa-trash-alt" aria-hidden="true"></i>
        </span>
        <span class="modifiedBtn" type="button" @click="modifiedTodo(index)">
          <i class="far fa-comment-dots"></i>
        </span>
      </li>
    </transition-group>
    <!-- 수정 Modal 부분 -->
    <modal v-if="showModal" @close="showModal = false">
      <h3 slot="header">수정</h3>
      <span slot="body">
        <div class="inputBox shadow">
          <input type="text" v-model="modifiedItem" placeholder="수정한 내용을 입력하세요!" v-on:keyup.enter="updateTodo">
          <span class="addContainer" v-on:click="updateTodo">
            <i class="addBtn fas fa-plus" aria-hidden="true"></i>
          </span>
        </div>
      </span>
      <span slot="footer" @click="showModal = false">
        <i class="closeModalBtn fas fa-times" aria-hidden="true"></i>
      </span>
    </modal>
  </section>
</template>

<script>
import Modal from './common/Modal.vue'
export default {
  props: ['propsdata'],
  data () {
    return {
      showModal: false,
      modifiedItem: '',
      index: 0
    }
  },
  methods: {
    removeTodo (todoItem, index) {
      this.$emit('removeTodo', todoItem, index)
    },
    modifiedTodo (index) {
      this.showModal = !this.showModal
      this.index = index
    },
    updateTodo () {
      this.$emit('updateTodo', this.modifiedItem, this.index)
    }
  },
  components: {
    Modal: Modal
  }
}
</script>

<style scoped>
.list-enter-active, .list-leave-active {
  transition: all 1s;
}

.list-enter, .list-leave-to {
  opacity: 0;
  transform: translateY(30px);
}
ul {
  list-style-type: none;
  padding-left: 0px;
  margin-top: 0px;
  text-align: left;
}

li {
  display: flex;
  min-height: 50px;
  height: 50px;
  line-height: 50px;
  margin: 0.5rem 0;
  padding: 0 0.9rem;
  background: white;
  border-radius: 5px;
}

.checkBtn {
  line-height: 45px;
  color: #62acde;
  margin-right: 10px;
}

.removeBtn {
  margin-left: auto;
  color: #de4343;
}
.modifiedBtn{
  margin-left: 30px;
  color: blue;
}
input:focus {
  outline: none;
}
.inputBox {
  background: white;
  height: 50px;
  line-height: 50px;
  border-radius: 5px;
}
.inputBox input {
  border-style: none;
  font-size: 1.0rem;
  text-align: center;
}
.addContainer {
  float: right;
  background: linear-gradient(to right, #6478FB, #8763FB);
  display: block;
  width: 3rem;
  border-radius: 0 5px 5px 0;
}
.addBtn {
  color: white;
  vertical-align: middle;
}
</style>
