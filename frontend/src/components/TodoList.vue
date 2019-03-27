<template>
  <section>
    <ul>
      <li v-for="todoItem in todoItems" :key="todoItem.id" class="shadow">
        <i class="checkBtn fas fa-check" aria-hidden="true"></i>
          {{ todoItem.contents }}
          <span class="removeBtn" type="button" @click="removeTodo(todoItem.id)">
            <i class="far fa-trash-alt" aria-hidden="true"></i>
          </span>
      </li>
    </ul>
  </section>
</template>

<script>
export default {
  data () {
    return {
      todoItems: []
    }
  },
  created () {
    this.$http.get('/todo/list').then((list) => {
      this.todoItems = list.data
    })
  },
  methods: {
    removeTodo (id) {
      this.$http.get('/todo/delete/' + id).then().catch()
      this.todoItems.splice(id - 1, 1)
    }
  }
}
</script>

<style scoped>
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

</style>
