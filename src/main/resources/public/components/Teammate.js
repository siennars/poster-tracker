
export default {
    name: 'Teammate',
    template: `
    <div>
        <ul>
            <li v-for="teammate in teammates" v-bind:key="teammate.id" >           
            <span>{{teammate.name}}</span>
            <span>{{teammate.posterCount}}</span>   
                <button v-on:click="chooseTeammate(teammate)">Choose {{teammate.name}}</button>
            </li>
        </ul>
        <div v-show="displayTeammate">
            {{singleTeammate.name}}
            <ul>
                <li v-for="postersHung in singleTeammate.postersHung">{{singleTeammate.postersHung}}</li>
            </ul>
        </div>
        <!--
        <ul>
            <li v-for="poster in posters" v-bind:key="poster.id">
                <span>{{poster.city}}</span>
                <span>{{poster.location}}</span>
                <span>{{poster.hungBy}}</span>
            </li>
        </ul>
        -->
    </div>
    `,
    data: function () {
        return {
            teammates: [{
                id: '',
                name:'',
                posterCount: '',
            }],
            posters: [{
                id: '',
                city:'',
                location:'',
                hungBy:''
            }],
            teammatesPosters: [{
                id: '',
                city:'',
                location:'',
                hungBy:''
            }],
            teammatesPosters: [],
            showPosters: false,
            displayTeammate: false,
            singleTeammate : [{
                id: '',
                name: '',
                posterCount: '',
                postersHung: []
            }]
        }
    },
    mounted () {
        this.getTeammates();
        this.getPosters();
    },
    methods: {
        getTeammates: function () {
            axios.get("/api/v1/teammates/get")
            .then(response => (this.teammates = response.data)) 
            .catch(error => console.log(error))
        },
        getPosters: function () {
            axios.get("/api/v1/posters/get")
            .then(response => (this.posters = response.data)) 
            .catch(error => console.log(error))
        },
        chooseTeammate: function (teammate) {
            this.singleTeammate.id = teammate.id;
            console.log(this.singleTeammate.name);
            this.singleTeammate.name = teammate.name;
            this.singleTeammate.posterCount = teammate.posterCount;
            this.singleTeammate.postersHung = this.getTeammatesPosters(teammate.id);
            this.singleTeammate.postersHung = this.teammatesPosters;
            console.log(this.singleTeammate.postersHung);
            this.displayTeammate = true;

        },
        getTeammatesPosters: function (teammateId) {
                var id = teammateId;
                axios.get("/api/v1/posters/get/teammates/" + id)
                .then(response => (this.teammatesPosters = response.data)) 
                .catch(error => console.log(error));
                console.log(this.teammatesPosters);
                this.showPosters = true;
            }
        }

    }
